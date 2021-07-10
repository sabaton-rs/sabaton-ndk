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
$> bitbake core-image-minimal

```



