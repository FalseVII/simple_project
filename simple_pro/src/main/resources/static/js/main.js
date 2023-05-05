function deleteNode(){
    var id = document.getElementById("node-id").value;
    var xhr = new XMLHttpRequest();
    xhr.open("DELETE", "http://localhost:8080/api/v1/node/" + id, true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == "200") {
            document.getElementById("alert").innerHTML = "<div class=\"alert alert-success\" role=\"alert\">\n" +
                "  Node deleted successfully!\n" +
                "</div>";
            refreshDataTable();
        } else {
            document.getElementById("alert").innerHTML = "<div class=\"alert alert-danger\" role=\"alert\">\n" +
                "  Node not deleted!\n" +
                "</div>";
            refreshDataTable();
        }
    }

}

function addNode(){

    var id = document.getElementById("node-id").value;
    var name = document.getElementById("node-name").value;
    var location = document.getElementById("node-location").value;
    var latitude = document.getElementById("node-latitude").value;
    var longitude = document.getElementById("node-longitude").value;

    var data = JSON.stringify({
        "id": id,
        "name": name,
        "location": location,
        "latitude": latitude,
        "longitude": longitude
    });

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/api/v1/node", true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(data);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == "200") {
            document.getElementById("alert").innerHTML = "<div class=\"alert alert-success\" role=\"alert\">\n" +
                "  Node added successfully!\n" +
                "</div>";
            refreshDataTable()
        } else {
            document.getElementById("alert").innerHTML = "<div class=\"alert alert-danger\" role=\"alert\">\n" +
                "  Node not added!\n" +
                "</div>";
            refreshDataTable()
        }
    }

}

function updateNode(){

    var id = document.getElementById("node-id").value;
    var name = document.getElementById("node-name").value;
    var location = document.getElementById("node-location").value;
    var latitude = document.getElementById("node-latitude").value;
    var longitude = document.getElementById("node-longitude").value;

    var data = JSON.stringify({
        "id": id,
        "name": name,
        "location": location,
        "latitude": latitude,
        "longitude": longitude
    });

    var xhr = new XMLHttpRequest();
    xhr.open("PUT", "http://localhost:8080/api/v1/node/" + id, true);
    xhr.setRequestHeader('Content-Type', 'application/json');
    xhr.send(data);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4 && xhr.status == "200") {
            document.getElementById("alert").innerHTML = "<div class=\"alert alert-success\" role=\"alert\">\n" +
                "  Node updated successfully!\n" +
                "</div>";
            refreshDataTable()
        } else {
            document.getElementById("alert").innerHTML = "<div class=\"alert alert-danger\" role=\"alert\">\n" +
                "  Node not updated!\n" +
                "</div>";
            refreshDataTable()
        }
    }

}


async function fetchNodeData() {
    // Replace the URL with your server-side API URL
    const response = await fetch('http://localhost:8080/api/v1/nodes');
    const data = await response.json();
    return data;
}

$(document).ready(async function() {

    $('#node-form').on('submit', function(event) {
        event.preventDefault();
    });
    const nodeData = await fetchNodeData();
    $('#node-table').DataTable({
        data: nodeData,
        columns: [
            { data: 'id' },
            { data: 'name' },
            { data: 'location' },
            { data: 'latitude' },
            { data: 'longitude' }
        ]
    });
});

async function refreshDataTable() {
    // Fetch the updated node data from the server
    const nodeData = await fetchNodeData();

    // Clear the existing data in the DataTable
    const dataTable = $('#node-table').DataTable();
    dataTable.clear();

    // Add the updated data to the DataTable
    dataTable.rows.add(nodeData);

    // Redraw the DataTable to display the updated data
    dataTable.draw();
}
