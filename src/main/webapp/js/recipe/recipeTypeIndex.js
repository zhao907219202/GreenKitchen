

function show_more(name,typename){
	document.getElementById(name).style.display="";
	document.getElementById(typename+"_unfold").style.display="none";
	document.getElementById(typename+"_fold").style.display="";
}

function hide_more(name,typename){
	document.getElementById(name).style.display="none";
	document.getElementById(typename+"_unfold").style.display="";
	document.getElementById(typename+"_fold").style.display="none";
}