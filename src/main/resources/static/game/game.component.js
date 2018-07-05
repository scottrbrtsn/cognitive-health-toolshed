angular.module('myApp')
    .component('game', {
        templateUrl: '/game/game.template.html',
        controller: function($scope, $resource) {
            var ctrl = this;

            ctrl.$onInit = function () {

            }

            var view1N = document.getElementById("box1N");
            var view1S = document.getElementById("box1S");
            var view1E = document.getElementById("box1E");
            var view1W = document.getElementById("box1W");
            var view2N = document.getElementById("box2N");
            var view2S = document.getElementById("box2S");
            var view2E = document.getElementById("box2E");
            var view2W = document.getElementById("box2W");
            var view3N = document.getElementById("box3N");
            var view3S = document.getElementById("box3S");
            var view3E = document.getElementById("box3E");
            var view3W = document.getElementById("box3W");
            var view4N = document.getElementById("box4N");
            var view4S = document.getElementById("box4S");
            var view4E = document.getElementById("box4E");
            var view4W = document.getElementById("box4W");

            var views = [view1E, view1N, view1W, view1S, view2E, view2N, view2W, view2S, view3E, view3N, view3W, view3S, view4E, view4N, view4W, view4S];

            var current = views[0];
            var east = 0;
            var north = 1;
            var south = 2;
            var west = 3;
            var blockNumber = 0;
            var view = 0;
            var hide;
            var direction = 0;

            ctrl.left = function (){
                hide= current;
                hide.style = "display:none";
                if(direction%4== 3){ view= view - 3;}
                else{view ++;}
                direction = view%4;
                console.log("direction: " + direction);
                current= views[view];
                current.style = "display:inline";

            }


            ctrl.right = function (){
                hide= current;
                hide.style = "display:none";


                if(view%4 ==0){ view = view +3;}
                else{view --;}
                direction = view%4;
                console.log(direction);
                current= views[(view)];
                current.style = "display:inline";

                console.log("view: " + view%4);
                console.log("direction: " + direction%4);
                console.log("blockNumber: " + blockNumber);
            }


            ctrl.forward = function(){
                if(direction%4 == 0 && blockNumber%10 < 1){ //move east
                view = view + 4;
                hide= current;
                hide.style = "display:none";
                direction = view%4;
                //console.log(direction+(blockNumber*4));
                blockNumber ++;
                current= views[view];
                current.style = "display:inline";
                }

                if(direction%4 == 1 && blockNumber>=10){//move north

                hide= current;
                hide.style = "display:none";
                direction = view%4;
                //console.log(direction+(blockNumber*4));
                blockNumber = blockNumber - 10;
                current= views[direction+(blockNumber*4)];
                current.style = "display:inline";

                view = view -8;
                }

                if(direction%4 == 2 && blockNumber%10 > 0){ //move west
                view=view-4;
                hide= current;
                hide.style = "display:none";
                direction = view%4;
                //console.log(direction+(blockNumber*4));

                blockNumber --;
                current= views[view];
                current.style = "display:inline";

                }


                if(direction%4 == 3 && blockNumber < 10){//move south
                view=view+8;
                hide= current;
                hide.style = "display:none";
                direction = view%4;
                //console.log(direction+(blockNumber*4));

                blockNumber = blockNumber + 10;
                current= views[view];
                current.style = "display:inline";

                }



            console.log("view: " + view%4);
            console.log("direction: " + direction%4);
            console.log("blockNumber: " + blockNumber);


            } //end forward

        }

    });