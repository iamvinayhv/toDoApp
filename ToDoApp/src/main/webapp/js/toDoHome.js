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
		
		if(event.target.id=="note")
			{
				return;
			}
		/*else {
			$("#pop").css("display", "none");
			jQuery('#main').css('opacity', '1');
			return;
		}*/
		
		
		
		
		if( event.target.id=="take" || event.target.id=="Title" || event.target.id=="Note" || event.target.id=="i" ||event.target.id=="tt")
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
	
	
	
	/*$('#onNote').on('click', function() {

		console.log("dddddddd");
		var title = $("#tit").html();
		var note = $("#not").html();
		var rem = $("#re").html();
		
		console.log(title);
		
		$("#pop").html("<b>"+title + "</b><br><br>" + note+ "<br>" + rem);
		$("#pop").show();
		$("main").fadeIn();
		
		if(event.target.id=="nav") {
			$("main").fadeOut();
		}

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
	}, 1200);

}



function upDate(title, note, rem, id) {
	
	
	console.log(title);
	document.getElementById("updt").innerHTML = ("<b><form action=\"updateNote\" method=\"post\"><input style=\" width: 150px; type=\"text\" value="+title+" name=\"title\">" + "</b><br><br>" +
			"<input style=\" width: 150px;\" type=\"text\" value="+note+" name=\"note\">" + "<br>" + rem +"<input style=\"visibility: hidden;\" type=\"number\" value="+id+" name=\"id\">"+"<br> <input id=\"up\" type=\"submit\" value=\"update\"></form>");
	document.getElementById("updt").style.visibility = "visible";
	
	
}



function design(id) {
	console.log(id);
	document.getElementById(id).style.boxShadow = "5px 5px 10px  black";
}

function designOut(id) {
	document.getElementById(id).style.boxShadow = "none";
}




function takeDesign() {
	document.getElementById("take").style.boxShadow = "5px 5px 10px  black";
    document.getElementById("newNote").style.boxShadow = "5px 5px 10px  black";
}

function takeDesignOut() {
    document.getElementById("newNote").style.boxShadow = "none";
    document.getElementById("take").style.boxShadow = "none";
}







function addNote() {
	
	var title=document.getElementById("Title").value;
	var note=document.getElementById("Note").value;
	
	console.log("gjmjmjk");
	var data = {title:title , note:note};
	
console.log(title+"  fox  "+note);
	$.ajax({
		type: "POST",
		url: "addNote",
		data:data,
		dataType:'json',
		success : function(g,h) {
			console.log("success",g);
			display(data);
		},
		error : function(e,a, b) {
			console.log(e);
			console.log(a);
			console.log(b);
			console.log("error  ");
		}
	});
}

function display(data) {
	
	console.log(data.note);
	var oldDiv = document.createElement("div");
	var newDiv = document.createTextNode(data.note+""+data.title);
	oldDiv.appendChild(newDiv);
	document.getElementById("naya").appendChild(oldDiv);
	//document.body.appendChild(oldDiv);
	console.log("n");
}


function get() {
	
	$.ajax({
		type: "POST",
		url: "toDoHome",
		dataType:'json',
		success : function(todoList,h) {
			console.log("success",h);
			
		},
		error : function(e,a, b) {
			console.log(e);
			console.log(a);
			console.log(b);
			console.log("error l ");
		}
	});
}


