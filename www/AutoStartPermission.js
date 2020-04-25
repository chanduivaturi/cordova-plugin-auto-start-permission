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
  
    console.log('pluigins1', window.plugins.AutoStartPermission);
    console.log('pluigins2', window.plugins.AutoStartPermission.getAutoStartPermission);
    return window.plugins.AutoStartPermission;
  };
  
  cordova.addConstructor(AutoStartPermission.install);