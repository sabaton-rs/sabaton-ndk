DESCRIPTION = "Opendnssec SoftHSM Library"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ef3f77a3507c3d91e75b9f2bdaee4210"
SECTION = "libs"

inherit autotools pkgconfig

DEPENDS = "openssl zlib sqlite3 sqlite3-native"

SRC_URI = "git://github.com/opendnssec/SoftHSMv2.git;protocol=https;branch=master"
SRCREV = "369df0383d101bc8952692c2a368ac8bc887d1b4"
PV = "2.5.0"
PR = "r0"

S = "${WORKDIR}/git"

EXTRA_OECONF += " \
    --with-openssl=${STAGING_EXECPREFIXDIR} \
    --with-crypto-backend=openssl \
    --enable-ecc \
    --enable-gost \
    --enable-eddsa \
    --with-objectstore-backend-db \
    "

FILES:${PN} += "${libdir}/softhsm/libsofthsm2.so"
FILES:${PN}-dev = "${libdir}/softhsm/* ${includedir}"
FILES:${PN}-dbg += "${libdir}/softhsm/.debug"
FILES:${PN}-staticdev += "${libdir}/softhsm/*.a "

