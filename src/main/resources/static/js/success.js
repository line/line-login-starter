$(document).ready(function() {

  $("#verify").on("click", function(){
    post("../api/verify").done(function(data) {
      if(data.scope) {
        alert("Access Token is VALID");
      } else {
        alert("Access Token is INVALID");
      }
    });
  });

  $("#refreshToken").on("click", function(){
    post("../api/refreshToken").done(function(data) {
      if(data.scope) {
        alert("Access Token has been refreshed");
      } else {
        alert("Access Token has not been refreshed");
      }
    });
  });

  $("#revoke").on("click", function(){
    post("../api/revoke").done(function(data) {
      alert("Access Token has been revoked");
    });
  });

});


var post = function(url) {
  var def = jQuery.Deferred();
  jQuery.ajax({
    type: 'POST',
    url: url,
    success: function(value) {
      def.resolve(value);
    },
    error: function(xhr) {
      def.reject(xhr.responseText);
    }
  });
  return def.promise();
};
