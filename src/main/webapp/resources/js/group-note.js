
$(function() {

	CKEDITOR.replace('ckeditor',{
		skin: 'moonocolor',
		enterMode: '2',
		shiftEnterMode: '3',
		height: '400px',
		inlinesave : {
				  postUrl: '/myurl',
				  postData: {test: true},
				  useJSON: false,

				  // Callbacks...
				  onSave: function(editor) { console.log('clicked save', editor); },                                   
				  onSuccess: function(editor, data) { console.log('save successful', editor, data); },                 
				  onFailure: function(editor, status, request) { console.log('save failed', editor, status, request); }
				},
		toolbar: 
			[['Print','-','Undo','Redo'],
			 ['Font'],
			 ['FontSize'],
			 ['TextColor','BGColor','-','Bold','Italic','Underline','Strike'],
			 ['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock','-','Outdent','Indent'],
			 ['Subscript','Superscript','RemoveFormat'],
			 ['NumberedList','BulletedList'],
			 ['Link','Image'],
			 ['Table','HorizontalRule']],
		filebrowserImageUploadUrl: '${pageContext.request.contextPath}/personalData/imageUpload.dvn'
	});
	
	var sendNoteDataaa;
	
	$("#sendNoteData").click(function() {
        var sendNoteData = CKEDITOR.instances.ckeditor.getData();
        var noteText = $('#ckeditor').val(sendNoteData);
        $("#noteForm").submit();   
        
     });

});

function noteAjax() {
	var sendNoteTitle = $(".note-title").val();
	var sendNoteData = CKEDITOR.instances.ckeditor.getData();

	
	console.log(sendNoteTitle + " : " + sendNoteData);
	
}