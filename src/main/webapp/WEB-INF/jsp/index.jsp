<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page  contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css"
          href="webjars/bootstrap/4.1.3/css/bootstrap.min.css"/>

</head>
<body>



<div class="container">

    <div class="starter-template">
        <h1>Cálculo de custo</h1>
        <h2>Exercicio 1 - Softplan</h2>
    </div>


    <form:form method="POST"  action="/calcCusto" modelAttribute="logisticaDTO">
        <div class="form-group">
            <label for="drp" path="drp">Distância em rodovia pavimentada</label>
            <form:input type="number" path="distRodPavimentada" class="form-control" id="drp" placeholder="0" min="0"/>
            <small id="passwordHelpBlock" class="form-text text-muted">
                Distância em quilômetros
            </small>
        </div>
        <div class="form-group">
            <label for="drnp" path="drnp">Distância em rodovia não-pavimentada</label>
            <form:input type="number" path="distRodNaoPavimentada" class="form-control" id="drnp" placeholder="0" min="0"/>
            <small id="passwordHelpBlock" class="form-text text-muted">
                Distância em quilômetros
            </small>
        </div>
        <div class="form-group">
            <label path="veiculos">Veículo utilizado</label>
            <form:select path="veiculo"  items="${veiculos}" cssClass="custom-select" />
        </div>
        <div class="form-group">
            <label for="ct" path="ct">Carga transportada</label>
            <form:input type="number" path="cargaTransp" class="form-control" id="ct" placeholder="0" min="0"/>
            <small id="passwordHelpBlock" class="form-text text-muted">
                Peso da carga em toneladas
            </small>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form:form>
</div>
<!-- /.container -->

<script type="text/javascript"
        src="webjars/bootstrap/4.1.3/js/bootstrap.min.js"/>
</body>

</html>
