
function loadOwnImages() {
  first = $('#first').val();
  limit = $('#limit').val();

  $.ajax({
    url : 'get_own_posts.php',
    dataType: "json",
    method: 'post',
    data: {
      start : first,
      limit : limit
    },
    success: function( data ) {
      flag = true;
      $('#loader').hide();
      if(data.count > 0 ) {

        first = parseInt($('#first').val());
        limit = parseInt($('#limit').val());

        $('#first').val( first + limit );

        $.each(data.content, function(key, value ) {
          var content = '<div class="picture_post">';
          content += '<div class="post_header">';
          content += '<div class="picture_post_header">';
          content += '<img class="avatar img-circle" src="' + value.profile_photo + '" />';
          content += '</div>';
          content += '<div class="username_post_header">';
          content += '<a>' + value.username + '</a>';
          content += '</div>';
          content += '</div>';
          content += '<div class="row">';
          content += '<div class="col-md-12 picture_post_content">';
          content += '<img class="img-responsive" src="' + value.path + '" />';
          content += '</div>';
          content += '</div>';
          content += '<div class="row">';
          content += '<div class="col-md-12 comments_post">';
          content += '<div class="comments_post_caption">';
          content += '<p>' + value.text + '</p>';
          content += '</div>';
          content += '<div class="comments_post_opinion">';
          content += '<div class="input-group">';
          content += '<span class="input-group-btn">';
          content += '<button class="btn btn-success glyphicon glyphicon-thumbs-up" data-toggle="tooltip" data-original-title="' + value.nbPositive + '" type="button"></button>';
          content += '<button class="btn btn-danger glyphicon glyphicon-thumbs-down" data-toggle="tooltip" data-original-title="' + value.nbNegative + '" type="button"></button>';
          content += '</span>';
          content += '<input type="text" class="comments_post_edit form-control" placeholder="Add a comment...">';
          content += '<span class="input-group-btn">';
          content += '<button class="btn btn-default glyphicon glyphicon-send" type="button"></button>';
          content += '<button class="btn btn-primary glyphicon glyphicon-comment" type="button"></button>';
          content += '</span>';
          content += '</div>';
          content += '</div>';
          content += '</div>';
          content += '</div>';
          content += '</div>';

          $('#content').append(content);
        });

        $('[data-toggle="tooltip"]').tooltip(); 
      }
    },
    error: function( data ){
      flag = true;
      no_data = false;
      alert('Something went wrong, Please contact admin');
    }
  });
}

loadOwnImages();

flag = true;
$(window).scroll(function() {
  if($(window).scrollTop() + $(window).height() >= $(document).height() - 1){

    no_data = true;
    if(flag && no_data){
      flag = false;
      $('#loader').show();
      loadOwnImages();
    }


  }
});
