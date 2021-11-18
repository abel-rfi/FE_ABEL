$(function(){
    'use strict';

    /** PIE CHART **/
    var randomScalingFactor = function() {
        return Math.round(Math.random() * 100);
    };

    var datapie = {
        datasets: [{
            data: [
                randomScalingFactor(),
                randomScalingFactor(),
                randomScalingFactor(),
                randomScalingFactor(),
                randomScalingFactor(),
            ],
            backgroundColor: [
                '#29B0D0',
                '#4C6579',
                '#F57E2E',
                '#C8E0E4',
                '#A6A7AC'
            ]
        }]
    };

    var optionpie = {
        responsive: true,
        legend: {
            display: false,
        },
        animation: {
            animateScale: true,
            animateRotate: true
        }
    };

    // For a doughnut chart
    var ctx6 = document.getElementById('chartPie');
    var myPieChart6 = new Chart(ctx6, {
        type: 'pie',
        data: datapie,
        options: optionpie
    });

    // // For a pie chart
    // var ctx7 = document.getElementById('chartDonut');
    // var myPieChart7 = new Chart(ctx7, {
    //     type: 'doughnut',
    //     data: datapie,
    //     options: optionpie
    // });

});
