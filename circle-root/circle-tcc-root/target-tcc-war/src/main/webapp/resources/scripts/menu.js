$(document).ready(function() {
	var cancelExtraction = document.getElementById('cancelExtraction');
	var nextStep = document.getElementById('nextStep');
	var viewResults = document.getElementById('viewResults');
	
	var backExtraction = document.getElementById('backExtraction');
	var listStopwords = document.getElementById('listStopwords');
		
	pages = new Array();
	
	/* Menu Preprocessing*/
	pages[0] = new Array(cancelExtraction, nextStep, viewResults);
	
	/* Menu Preprocessing View Results*/
	pages[1] = new Array(backExtraction, cancelExtraction);
	
	/* Menu StopWords*/
	pages[2] = new Array(cancelExtraction, nextStep, viewResults, listStopwords);
});

function setVisible(page) {
	--page;
	$.each(pages[page], function() {
		$(this).attr('rendered', 'true');
	});
}