# sabaton-ndk
The Yocto environment for the Sabaton Native SDK

# Install pre-requisites on Ubuntu
```
sudo apt-get install gawk wget git-core diffstat unzip texinfo gcc-multilib \
     build-essential chrpath socat libsdl1.2-dev xterm
```
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



