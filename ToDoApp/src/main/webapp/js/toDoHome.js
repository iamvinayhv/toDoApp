$(document).ready(function() {
	$('b').on('click', function(e) {

		if ($(this).hasClass('grid')) {
			$('#container div').removeClass('list').addClass('grid');
		} else if ($(this).hasClass('list')) {

			$('#container div').removeClass('grid').addClass('list');
		}
	});

	
	
	$('#take').on('click', function(event) {

		$("#newNote").show();

	});
	

	
	
	$(document).on('click','#done', function(event) {
		if (event.target.id = "take") {
			return;
		}
		$("#newNote").css("display", "none");
		$("#up").css("display", "none");

	});
	
	
	

	
	$('#sea').on('click', function(event) {

		$("#sea").css("background-color", "white");

	});
	
	
	
	
	
	
	$('#full').on('click', function(event) {

		$("#sea").css("background-color", "#f5b400");
		
		if( event.target.id=="take" || event.target.id=="Title" || event.target.id=="Note" || event.target.id=="i" )
		{
			return;
		}
		else {
			$("#newNote").css("display", "none");
		}
		

	});
	
	
	
	
	
	/*
	$("#main").click(function(){
        $("main").fadeOut();
    });
    
    $('#note').on('click', function(event) {

		$("#main").opacity=1;

	});

	
	$('#nav').on('click', function(event) {

		$("#main").opacity=1;

	});*/
	
	
	
	/*$('#note').on('click', function(event) {

		var title = $("#title").val();
		var note = $("#note").val();
		var rem = $("#rem").val();
		
		$("#pop").html("<b>"+title + "</b><br><br>" + note+ "<br>" + rem);

	});*/
	
	
	
	
	

	

});



/*java Script*/


function openNav() {
	document.getElementById("mySidenav").style.width = "250px";
	document.getElementById("nav").style.marginLeft = "250px";
}
function closeNav() {
	document.getElementById("mySidenav").style.width = "0px";
	document.getElementById("nav").style.marginLeft = "0px";
}






function showOption() {
	document.getElementById("show").style.visibility = "visible";
}

function hideOption() {
	document.getElementById("show").style.visibility = "visible";
}







function popUp(title, note, rem) {

	document.getElementById("pop").innerHTML = ("<b>"+title + "</b><br><br>" + note+ "" + rem);
	document.getElementById("pop").style.visibility = "visible";
	document.getElementById("main").style.opacity = 0.3;

	
	setTimeout(function() {
		document.getElementById("pop").style.visibility = "hidden";
		document.getElementById("main").style.opacity = 1;
	}, 1100);

}

function onBody() {
	
}



function upDate(title, note, rem, id) {
	
	
	console.log("vk");
	document.getElementById("updt").innerHTML = ("<b><form action=\"updateNote\" method=\"post\"><input style=\" width: 150px; type=\"text\" value="+title+" name=\"title\">" + "</b><br><br>" +
			"<input style=\" width: 150px;\" type=\"text\" value="+note+" name=\"note\">" + "<br>" + rem +"<input style=\"visibility: hidden;\" type=\"number\" value="+id+" name=\"id\">"+"<br> <input id=\"up\" type=\"submit\" value=\"update\"></form>");
	document.getElementById("updt").style.visibility = "visible";
	
	
}

