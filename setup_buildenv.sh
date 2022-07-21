if [[ ! -v SABATON_NDK_ROOT ]]; then
SABATON_NDK_ROOT=`pwd`
fi


[ ! -d "yocto/poky/buildtools" ] && yocto/poky/scripts/install-buildtools

# Source the build environment
. yocto/poky/buildtools/environment-setup-x86_64-pokysdk-linux

cd yocto/poky/

. oe-init-build-env 

###bitbake-layers add-layer ../../meta-clang/
bitbake-layers add-layer ../../meta-sabaton/
bitbake-layers add-layer ../../meta-selinux/

## Copy the aarch64 configuration to the local config
cp $SABATON_NDK_ROOT/yocto/meta-sabaton/conf/local.conf conf/local.conf
cp -r $SABATON_NDK_ROOT/yocto/meta-sabaton/conf/multiconfig conf/

#bitbake core-image-minimal -c populate_sdk

echo "Run the following command for building all"
echo "bitbake mc:aarch64:sabaton-ndk-image -c populate_sdk mc:armv7:sabaton-ndk-image -c populate_sdk"

#bitbake mc:aarch64:sabaton-ndk-image -c populate_sdk


