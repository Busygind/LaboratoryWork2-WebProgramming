<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <link rel="icon" href="favicon.ico" type="image/x-icon">
    <link rel="stylesheet" href="styles/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script type="text/javascript" charset="UTF-8"
            src="https://cdn.jsdelivr.net/npm/jsxgraph/distrib/jsxgraphcore.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/jsxgraph/distrib/jsxgraph.css" />
    <script src="js/VariableSelector.js"></script>
    <script src="js/Cleaner.js"></script>
    <script src="js/Updater.js"></script>
    <script src="js/Validator.js"></script>
    <script src="js/TableController.js" defer></script>
    <script src="js/GraphController.js"></script>
    <script src="js/DataController.js"></script>
</head>
<body onload="getDataFromServer()">
<div class="container">
    <header class="desc">
        <h1>Laboratory work #2</h1>
        <h2>Author: Busygin Dmitry, P32111</h2>
        <h2>Variant: 1121</h2>
    </header>
    <section class="main-panel">
        <div class="graph">
            <h2>Given area:</h2>
            <div id="jxgbox" class="jxgbox"></div>
            <button type="reset" id="clean-graph-button" onclick="cleanGraph()">
                <img src="resources/images/bin.png" height="20px">
            </button>
        </div>
        <div class="right-box">
            <section class="user-input">
                <form method="get" id="form" onsubmit="update($('#x-value').val(), $('#y-value').val(), getR()); return false">
                    <div class="values">
                        <label>Enter X value:</label>
                        <select class="x-values" id="x-value">
                            <option disabled selected></option>
                            <option value="-2">-2</option>
                            <option value="-1.5">-1.5</option>
                            <option value="-1">-1</option>
                            <option value="-0.5">-0.5</option>
                            <option value="0">0</option>
                            <option value="0.5">0.5</option>
                            <option value="1">1</option>
                            <option value="1.5">1.5</option>
                            <option value="2">2</option>
                        </select>
                        <div class="y-values">
                            <label>Enter Y value:</label><br>
                            <input type="text" class="y-text" maxlength="14" id="y-value" name="y-value" oninput="validateTextField()" required>
                        </div>
                        <label>Enter R value:</label>
                        <div class="r-values">
                            <input type="radio" name="r-value" id="r1" value="1" onclick="selectR('1')">
                            <label for="r1">1</label>
                            <input type="radio" name="r-value" id="r15" value="1.5" onclick="selectR('15')">
                            <label for="r15">1.5</label>
                            <input type="radio" name="r-value" id="r2" value="2" onclick="selectR('2')">
                            <label for="r2">2</label>
                            <input type="radio" name="r-value" id="r25" value="2.5" onclick="selectR('25')">
                            <label for="r25">2.5</label>
                            <input type="radio" name="r-value" id="r3" value="3" onclick="selectR('3')">
                            <label for="r3">3</label>
                        </div>
                    </div>
                    <div class="buttons">
                        <input id="reset" type="reset" value="Reset" onclick="cleanFields()">
                        <input id="submit" type="submit" value="Submit">
                    </div>
                </form>
            </section>
            <section class="actionCounter">

            </section>
        </div>
    </section>
    <section class="validationInfo">

    </section>
    <section class="table">
        <table id="table">
            <tr>
                <th>X</th>
                <th>Y</th>
                <th>R</th>
                <th>Current time</th>
                <th>Result</th>
            </tr>
        </table>
        <button type="reset" id="clean-table-button" onclick="cleanTable()">
            <img src="resources/images/bin.png" height="20px">
        </button>
    </section>
</div>
<footer>
    <img src="resources/images/logo_footer.png" height="80px">
</footer>
</body>