function searchTable() {

    // Declare variables
    const input = document.getElementById("tableInput");
    const filter = input.value.toUpperCase();
    const table = document.getElementById("searchableTable");
    const trs = table.tBodies[0].getElementsByTagName("tr");

    // Loop through first tbody's rows
    for (let i = 0; i < trs.length; i++) {

        // define the row's cells
        const tds = trs[i].getElementsByTagName("td");

        // hide the row
        if (tds.length > 0) {
            trs[i].style.display = "none";
        }
        // loop through row cells
        for (let i2 = 0; i2 < tds.length; i2++) {

            // if there's a match
            if (tds[i2].innerHTML.toUpperCase().indexOf(filter) > -1) {

                // show the row
                trs[i].style.display = "";

                // skip to the next row

            }
        }
    }

}