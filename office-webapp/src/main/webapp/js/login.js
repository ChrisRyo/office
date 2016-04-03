function login() {
  $.blockUI({ 
    css: { 
      border: 'none', 
      padding: '15px', 
      backgroundColor: '#000', 
      '-webkit-border-radius': '10px', 
      '-moz-border-radius': '10px', 
      opacity: .5, 
      color: '#fff' 
    }, 
    message:"登入中...",
  });

  $.ajax({
    type: 'POST',
    contentType: 'application/json',
    url: location.href,
    data: formToJSON(),
    success: function(json) {
      $.unblockUI();

      if (json.resultCode == 0) {
        alert("登入成功！");
        document.location.href = location.origin + json.data;
      } else {
        alert(json.data);
      }
    },
    error: function(xhr, ajaxOptions, thrownError) {
      $.unblockUI();

      alert(xhr.status);
      alert(thrownError);
    }
  });
}

function formToJSON() {
  return JSON.stringify({
    "userName": $('#userName').val(),
    "pwd": $('#pwd').val()
  });
}