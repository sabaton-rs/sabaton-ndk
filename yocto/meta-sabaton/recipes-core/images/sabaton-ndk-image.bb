SUMMARY = "Sabaton NDK packages"


LICENSE = "MIT"

inherit core-image


CORE_IMAGE_EXTRA_INSTALL = "libselinux cyclonedds libsodium llvm libseccomp checkpolicy iceoryx gstreamer1.0 alsa-lib gstreamer1.0-plugins-good gstreamer1.0-plugins-base libdrm zsh paho-mqtt dropbear softhsmv2 sqlite3 systemd systemd-container dlt-daemon net-tools curl busybox lvm2 libva libepoxy ffmpeg libgles2-mesa-dev libgles3-mesa-dev vulkan-loader strace weston seatd libinput"
#IMAGE_FEATURES += ""
