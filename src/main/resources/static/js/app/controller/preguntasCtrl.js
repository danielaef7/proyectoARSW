var app = angular.module("app",[]);

app.controller("control", function($scope,$log,$http) {
    $scope.pregunta = {tipo : "",
                    contenido : ""};
    $scope.preguntas = [];
     $scope.preguntaUpdate = {tipo : "Tipo",
                    contenido : "contenido"};
    $scope.usuario = {nombre : ""};
    $scope.usuarios = [];
    $log.debug('se creo el $scope');

 $scope.loadData = function() {
        $http({
            method: "GET",
            url: "preguntas"
        }).success(function(data) {
            $scope.preguntas = data;
        });
        $http({
            method: "GET",
            url: "usuarios"
        }).success(function(data) {
            $scope.usuarios = data;
        });
    };
    
    $scope.crearUsuario = function() {
        $log.debug($scope.usuario);
        $http({
            method  : 'POST',
            url     : 'usuario',
            data    : $scope.usuario
        }).success(function(data) {
            console.log(data);
            $scope.loadData();
        });
    };

    $scope.crearPregunta = function() {
        $log.debug($scope.pregunta);
        $http({
            method  : 'POST',
            url     : 'pregunta',
            data    : $scope.pregunta
        }).success(function(data) {
            console.log(data);
            $scope.loadData();
            alert("Pregunta Creada");
            location.reload(); 
        });
    };
    
    $scope.listarPreguntas = function(){
            var configList ={
                method: "GET",
                url: "preguntas"+ $scope.pregunta.tipo
            };
            var response = $http(configList);
            response.success(function (data, status, headers, config) {
                $scope.preguntas = data;
            });
    };
    
    $scope.delete = function(index) {
        $log.debug($scope.preguntas[index]);
        $http({
            method  : 'delete',
            url     : "pregunta",
           data    :  index, 
          headers: {"Content-Type": "application/json;charset=utf-8"}
        }).success(function() {    
            $scope.loadData();
        });
            
    };
    
    $scope.edit = function (index) {
        $scope.preguntaUpdate.content=document.getElementsByName("contenidoP")[index].value;
        var configList = {
                method  : 'PUT',
                url     : 'pregunta'+index,
                data    :  $scope.preguntaUpdate
        };

        var response=$http(configList);
        response.success(function(data, status, headers, config) {
            $scope.preguntas = data;
        });
    };
    
});
