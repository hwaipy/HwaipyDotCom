$(document).ready(function () {
    var date = new Date()
    var dateString = "" + date.getFullYear() + date.getMonth() + date.getDate() + date.getHours() + date.getMinutes() + date.getSeconds() + date.getMilliseconds()
    document.getElementById('AL').innerHTML = "<p>Ali</p><img src=\"/wydra/weathers?lon=80.026&lat=32.325&station=AL&seed=" + dateString + "\"/>"
    document.getElementById('DLH').innerHTML = "<p>Delingha</p><img src=\"/wydra/weathers?lon=97.727&lat=37.379&station=DLH&seed=" + dateString + "\"/>"
    document.getElementById('NS').innerHTML = "<p>Nanshan</p><img src=\"/wydra/weathers?lon=87.177&lat=43.475&station=NS&seed=" + dateString + "\"/>"
    document.getElementById('XL').innerHTML = "<p>Xinglong</p><img src=\"/wydra/weathers?lon=117.577&lat=40.396&station=XL&seed=" + dateString + "\"/>"
    document.getElementById('LJ').innerHTML = "<p>Lijiang</p><img src=\"/wydra/weathers?lon=100.029&lat=26.694&station=LJ&seed=" + dateString + "\"/>"
    document.getElementById('SH').innerHTML = "<p>Shanghai</p><img src=\"/wydra/weathers?lon=121.542&lat=31.126&station=SH&seed=" + dateString + "\"/>"
});