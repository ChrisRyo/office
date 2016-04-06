/**
 * chrisryo
 */
var BlockuiUtils = function() {
  return {
    // wrMetronicer function to  block element(indicate loading)
    blockUI: function(options) {
        options = $.extend(true, {}, options);
        var html = '';

        html = "<div class='overlay'><i class='fa fa-refresh fa-spin'></i> Loading</div>";

        if (options.target) { // element blocking
            var el = $(options.target);
            // if (el.height() <= ($(window).height())) {
            //     options.cenrerY = true;
            // }
            el.block({
                message: html,
                baseZ: options.zIndex ? options.zIndex : 1000,
                centerY: false,
                css: {
                    top: '50%',
                    border: 'none',
                    backgroundColor: '#000', 
                    '-webkit-border-radius': '10px', 
                    '-moz-border-radius': '10px', 
                    opacity: .5, 
                    color: '#fff' 
                },
                overlayCSS: {
                    backgroundColor: options.overlayColor ? options.overlayColor : '#555',
                    opacity: options.boxed ? 0.05 : 0.1,
                    cursor: 'wait'
                }
            });
        } else { // page blocking
            $.blockUI({
                message: html,
                baseZ: options.zIndex ? options.zIndex : 1000,
                css: {
                    border: 'none',
                    backgroundColor: '#000', 
                    '-webkit-border-radius': '10px', 
                    '-moz-border-radius': '10px', 
                    opacity: .5, 
                    color: '#fff' 
                },
                overlayCSS: {
                    backgroundColor: options.overlayColor ? options.overlayColor : '#555',
                    opacity: options.boxed ? 0.05 : 0.1,
                    cursor: 'wait'
                }
            });
        }
    },

    // wrMetronicer function to  un-block element(finish loading)
    unblockUI: function(target) {
        if (target) {
            $(target).unblock({
                onUnblock: function() {
                    $(target).css('position', '');
                    $(target).css('zoom', '');
                }
            });
        } else {
            $.unblockUI();
        }
    },
  }
}();