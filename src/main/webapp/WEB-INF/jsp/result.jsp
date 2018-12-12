<%--
  Created by IntelliJ IDEA.
  User: tiago
  Date: 10/12/18
  Time: 15:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css"
          href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"/>
    <title>Resultado</title>
</head>
<body>
<div class="container">
<table class="table">
    <thead>
    <tr>
        <th scope="col">Distância. em rodovia pavimentada</th>
        <th scope="col">Distância. em rodovia não pavimentada</th>
        <th scope="col">Veículo utilizado</th>
        <th scope="col">Carga transportada</th>
        <th scope="col">Custo do transporte</th>
    </tr>
    </thead>
    <tbody>
    <tr>
        <td>${distRodPavimentada}</td>
        <td>${distRodNaoPavimentada}</td>
        <td>${veiculo}</td>
        <td>${cargaTransp}</td>
        <td>${total}</td>
    </tr>
    </tbody>
</table>
<p><a href="/">Voltar</a></p>
</div>
<script type="text/javascript"
        src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"/>
</body>
</html>
