function getAll() {
  const xhttp = new XMLHttpRequest();
  xhttp.onload = function() {
    document.getElementById("demo").innerHTML = this.responseText;
  }
  xhttp.open("GET", "http://localhost:8080/api/hospital");
  xhttp.send();
}

function getId() {
  var id=document.getElementById("hid").value;
  const xhttp = new XMLHttpRequest();
  xhttp.onload = function() {
    document.getElementById("id").innerHTML = this.responseText;
  }
  xhttp.open("GET", "http://localhost:8080/api/hospital/id/"+id);
  xhttp.send();
}

function getName() {
  var name=document.getElementById("hname").value;
  const xhttp = new XMLHttpRequest();
  xhttp.onload = function() {
    document.getElementById("name").innerHTML = this.responseText;
  }
  xhttp.open("GET", "http://localhost:8080/api/hospital/name/"+name);
  xhttp.send();
}

function getNasaPage() {
  const xhttp = new XMLHttpRequest();
  xhttp.onload = function() {
    document.getElementById("nasa").innerHTML = this.responseText;
  }
  xhttp.open("GET", "https://api.nasa.gov/planetary/apod?api_key=gNXthHIrQL4lORIfdkPBdhWFh47bA0Lps9Lie0fe");
  xhttp.send();
}