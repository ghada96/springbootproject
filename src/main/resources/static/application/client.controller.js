(function () {
    'use strict';

    angular
        .module('app')
        .controller('ClientController', ClientController);

    ClientController.$inject = ['$http']; //access to restcontroller we need a dependancy to http

    function ClientController($http) {
        var vm = this;
        vm.listClient=[];
        vm.getAll=getAll;


        init();
        function init() {
            getAll();

        }

        function getAll() {
            var url="/listclient";
            var data=$http.get(url);
            data.then(function (response) {
                vm.listClient=response.data;
            });

        }

    }
})();