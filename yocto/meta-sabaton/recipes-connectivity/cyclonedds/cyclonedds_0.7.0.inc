SUMMARY = "Eclipse Cyclone DDS is a very performant and robust open-source DDS implementation."
LICENSE = "Eclipse-2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=ca2dafd1f07f3cd353d0454d3c4d9e80"

SRC_URI = "git://github.com/eclipse-cyclonedds/cyclonedds.git;protocol=git;tag=0.7.0"

INSANE_SKIP_${PN} += "dev-so dev-deps dev-elf"
INSANE_SKIP_${PN}-dev += "dev-so dev-deps dev-elf"


DEPENDS = "openssl"
RDEPENDS_${PN} = ""

inherit cmake

S = "${WORKDIR}/git"

EXTRA_OECMAKE = " \
        -DBUILD_IDLC=OFF \
        -DENABLE_TOPIC_DISCOVERY=ON \
        -DENABLE_TYPE_DISCOVERY=ON \
        "

FILES_${PN} += "${libdir}/*.so"
FILES_${PN}-dev = "${libdir}/* ${includedir}"
