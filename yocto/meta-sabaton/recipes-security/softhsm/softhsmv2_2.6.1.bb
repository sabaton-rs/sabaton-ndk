DESCRIPTION = "Opendnssec SoftHSM Library"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ef3f77a3507c3d91e75b9f2bdaee4210"
SECTION = "libs"

inherit autotools pkgconfig

DEPENDS = "openssl zlib sqlite3"

SRC_URI = "git://github.com/opendnssec/SoftHSMv2.git;protocol=https;branch=develop"
SRCREV = "7f99bedae002f0dd04ceeb8d86d59fc4a68a69a0"
PV = "2.6.1"
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

FILES_${PN} += "${libdir}/softhsm/lib*.so.* ${mntdir}/*"
FILES_${PN}-dbg += "${libdir}/softhsm/.debug"
FILES_${PN}-staticdev += "${libdir}/softhsm/*.a "
FILES_${PN}-dev += "${libdir}/softhsm/*.la ${libdir}/softhsm/lib*.so"

INSANE_SKIP_${PN}-dev = "dev-elf"


