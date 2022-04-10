SUMMARY = "Eclipse Cyclone DDS is a very performant and robust open-source DDS implementation."
LICENSE = "Eclipse-2"
LIC_FILES_CHKSUM = "file://${WORKDIR}/git/LICENSE;md5=ca2dafd1f07f3cd353d0454d3c4d9e80"
SRC_URI = "https://github.com/eclipse-cyclonedds/cyclonedds.git;protocol=git"

inherit cmake
#inherit native

INSANE_SKIP_${PN} += "dev-so dev-deps dev-elf"
INSANE_SKIP_${PN}-dev += "dev-so dev-deps dev-elf"

BBCLASSEXTEND = "native"

DEPENDS = "openssl cyclonedds-native iceoryx"
RDEPENDS_${PN} = ""

S = "${WORKDIR}/git"

EXTRA_OECMAKE = " \
        -DBUILD_IDLC=OFF \
        -DENABLE_TOPIC_DISCOVERY=ON \
        -DENABLE_TYPE_DISCOVERY=ON \
        "

FILES_${PN} += "${libdir}/*.so"
FILES_${PN}-dev = "${libdir}/* ${includedir}"

do_install_append() {

	install ${WORKDIR}/build/bin/ddsconf ${D}${bindir}	 || true
}
