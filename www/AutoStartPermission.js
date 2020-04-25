var exec = require('cordova/exec');

function AutoStartPermission() {

}

AutoStartPermission.prototype.isAutoStartPermissionAvailable = function() {
    exec(function(res){}, function(err){}, "AutoStartPermission", "isAutoStartPermissionAvailable", []);
}

AutoStartPermission.prototype.getAutoStartPermission = function() {
    exec(function(res){}, function(err){}, "AutoStartPermission", "getAutoStartPermission", []);
}

AutoStartPermission.install = function () {
    if (!window.plugins) {
      window.plugins = {};
    }
  
    window.plugins.AutoStartPermission = new AutoStartPermission();
  
  
    return window.plugins.AutoStartPermission;
  };
  
  cordova.addConstructor(AutoStartPermission.install);