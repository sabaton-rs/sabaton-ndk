SABATON_NDK_ROOT=`pwd`

[ ! -d "yocto/poky/buildtools" ] && yocto/poky/scripts/install-buildtools

# Source the build environment
. yocto/poky/buildtools/environment-setup-x86_64-pokysdk-linux

cd yocto/poky/

. oe-init-build-env 

bitbake-layers add-layer ../../meta-clang/
bitbake-layers add-layer ../../meta-sabaton/

## Copy the aarch64 configuration to the local config
cp $SABATON_NDK_ROOT/buildconf/aarch64_sabaton/local.conf conf/local.conf

#bitbake core-image-minimal -c populate_sdk



