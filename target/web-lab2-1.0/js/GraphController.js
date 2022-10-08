function createRectangle(board, r) {
    let pt1 = board.create('point', [0, 0], {name: '', fixed: true, size: 0});
    let pt2 = board.create('point', [-r / 2, 0], {name: '', fixed: true, size: 0});
    let pt3 = board.create('point', [-r / 2, r], {name: '', fixed: true, size: 0});
    let pt4 = board.create('point', [0, r], {name: '', fixed: true, size: 0});
    return board.create('polygon', [pt1, pt2, pt3, pt4],
        {fillColor: '#fabf4d', fillOpacity: 1, borders: {strokeColor: 'black'}});
}

function createTriangle(board, r) {
    let pt1 = board.create('point', [0, 0], {name: '', fixed: true, size: 0});
    let pt2 = board.create('point', [-r, 0], {name: '', fixed: true, size: 0});
    let pt3 = board.create('point', [0, -r], {name: '', fixed: true, size: 0});
    return board.create('polygon', [pt1, pt2, pt3], {fillColor: '#fabf4d', fillOpacity: 1, borders: {strokeColor: 'black'}});
}

function createCircle(board, r) {
    let cen = board.create('point', [0, 0], {name: '', fixed: true, size: 0});
    let pt1 = board.create('point', [r, 0], {name: '', fixed: true, size: 0});
    let pt2 = board.create('point', [0, r], {name: '', fixed: true, size: 0});
    return board.create('sector', [cen, pt1, pt2], {name: '', fillColor: '#fabf4d', fillOpacity: 1, strokeColor: 'black'});
}

$(document).ready(function () {
    drawBoard()
});

function drawObjects(drawnObjects, board, r) {
    if (checkR(r)) {
        for (const object of drawnObjects) {
            let points = object.ancestors;
            for (const point in points) board.removeObject(point);
            board.removeObject(object);
        }
        let rectangle = createRectangle(board, r);
        let triangle = createTriangle(board, r);
        let circle = createCircle(board, r);
        return [rectangle, triangle, circle];
    }
    return [];
}

var globalBoard;
function drawBoard() {

    let board = JXG.JSXGraph.initBoard('jxgbox', {boundingbox: [-6, 6, 6, -6], axis: true, showCopyright: false});
    globalBoard = board;
    let drawnObjects = []

    drawnObjects = drawObjects(drawnObjects, board, getR());

    document.getElementById('jxgbox').addEventListener("click", mouseClickListener);

    $('input[type="radio"][name="r-value"]').change(function () {
        drawnObjects = drawObjects(drawnObjects, board, this.value);
    });
}

function drawPoint(board, x, y, result) {
    if (result) {
        board.create("point", [x, y], {name: '', fixed: true, size: 1, fillColor: '#179a02', strokeColor: '#179a02'});
    } else {
        board.create("point", [x, y], {name: '', fixed: true, size: 1, fillColor: '#bb1010', strokeColor: '#bb1010'});
    }
}

function mouseClickListener(event) {
    let coords = globalBoard.getUsrCoordsOfMouse(event);
    if (checkR(getR())) {
        update(coords[0].toString(), coords[1].toString(), getR())
    }
}