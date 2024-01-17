# seatd_0.7.0.bbappend

PACKAGECONFIG ?= " \
    ${@bb.utils.filter('DISTRO_FEATURES', 'systemd', d)} \
"
