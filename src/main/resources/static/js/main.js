   	$(document).ready(function() {
            $('#loader').hide();
            $("#signup").on("click", function() {
                var file = $("#file").val(); 
                // Get form
                var form = $('#register-form')[0];
                var data = new FormData(form);
                //alert(data);
                var str = JSON.stringify(data);
                //alert(str);
                //console.log(data);
                $('#loader').show();
                if (file === "") {
                    $('#loader').hide();
                    $("#file").css("border-color", "red");
                    $("#error_file").html("Please fill the required field.");
                } else {
                    $("#file").css("border-color", "");
                    $('#error_file').css('opacity', 0);
                    $.ajax({
                        type: 'POST',
                        enctype: 'multipart/form-data',
                        data: data,
                        url: "/image-upload/saveEmployee",
                        processData: false, //prevent jQuery from automatically transforming the data into a query string
                        contentType: false, // tell jQuery not to set contentType
                        cache: false,     
                        success: function(data, statusText, xhr) {
                        console.log(xhr.status);
                        if(xhr.status == "200") {
                        	$('#loader').hide(); 
                            $("#register-form")[0].reset();
                            $("#error").text("");
                            $("#success").text(data);
                            $('#success').delay(5000).fadeOut('slow');
                            $("#signup").prop("disabled", false);
                         }	   
                        },
                        error: function(e){
                        	$('#loader').hide();
                            $("#error").text(e.responseText);
                            $('#error').delay(10000).fadeOut('slow');
                            $("#signup").prop("disabled", false);
                        }
                    });
                }
            });
        });