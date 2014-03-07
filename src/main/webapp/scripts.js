//Peidab kõik elemendid klassiga "content" ja kuvab vastavalt id-le
function showdiv(id){
	
	var divsToHide = document.getElementsByClassName("content");
	
	for(var i = 0; i < divsToHide.length; i++){
		divsToHide[i].style.display="none";
    }
	
	document.getElementById(id).style.display="block";
};



