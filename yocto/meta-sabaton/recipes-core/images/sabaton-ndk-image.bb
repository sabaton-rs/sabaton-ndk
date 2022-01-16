SUMMARY = "Sabaton NDK packages"


LICENSE = "MIT"

inherit core-image


CORE_IMAGE_EXTRA_INSTALL = "libselinux cyclonedds libsodium llvm libseccomp checkpolicy iceoryx gstreamer1.0 alsa-lib gstreamer1.0-plugins-good gstreamer1.0-plugins-base libdrm zsh paho-mqtt dropbear softhsmv2 sqlite3 systemd"
#IMAGE_FEATURES += ""
