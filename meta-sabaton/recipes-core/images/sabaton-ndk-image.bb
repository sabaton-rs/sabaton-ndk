SUMMARY = "Stargazer production image"


LICENSE = "MIT"

inherit core-image

CORE_IMAGE_EXTRA_INSTALL = "libselinux cyclonedds libsodium"
#IMAGE_FEATURES += ""
