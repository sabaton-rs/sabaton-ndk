SUMMARY = "Sabaton NDK packages"


LICENSE = "MIT"

inherit core-image

CORE_IMAGE_EXTRA_INSTALL = "libselinux cyclonedds libsodium llvm libseccomp checkpolicy-native"
#IMAGE_FEATURES += ""
