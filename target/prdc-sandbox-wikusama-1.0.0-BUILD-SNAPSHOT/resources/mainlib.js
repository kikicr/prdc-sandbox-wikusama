//foundation helper
var foundationHelper={alert:{}};

foundationHelper.alert.alertBoxCreate=function(target){
	var alertMsg='<div id="deleteModal" class="reveal-modal tiny" data-reveal aria-labelledby="modalTitle" aria-hidden="true" role="dialog">'+
	'<h5 id="modalTitle"><i class="fa fa-exclamation-triangle "></i> confirmation box</h5>'
	  +'<p>apakah anda yakin menghapus data #<span id="caption-id"></span></p>'
	  +'<p class="lead right"><a href="" class="button success tiny" id="link-hapus">Ya</a>&nbsp;<a href="" class="button alert tiny">tidak</a></p>'
	  	+'<a class="close-reveal-modal" aria-label="Close">&#215;</a>'
		+'</div>';	
	$(target).html(alertMsg);
		
}		
foundationHelper.alert.alertShow=function(url,caption){
		$("#link-hapus").attr('href',url);
		$("#caption-id").html(caption);
		$('#deleteModal').foundation('reveal', 'open');
	}
