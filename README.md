# sabaton-ndk
The Yocto environment for the Sabaton Native SDK


# Build instructions
``` 
$> git clone --recurse-submodules git@github.com:sjames/sabaton-ndk.git
```
```
$> cd poky
$> . oe-init-build-env
$> bitbake-layers add-layer ../../meta-clang/
$> bitbake-layers add-layer ../../meta-sabaton/

## Copy the config file to the build folder

$> cp buildconf/aarch64_sabaton/local.conf conf/local.conf

## Edit the conf/local.conf to set DISTRO ?= "sabaton" and correct machine type
$> bitbake core-image-minimal -c populate_sdk

```



