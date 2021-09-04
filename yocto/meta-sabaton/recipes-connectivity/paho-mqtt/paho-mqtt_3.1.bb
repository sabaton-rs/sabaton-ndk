DESCRIPTION = "Paho MQTT - user libraries for the MQTT and MQTT-SN protocols"
DESCRIPTION = "Client implementation of open and standard messaging protocols for Machine-to-Machine (M2M) and Internet of Things (IoT)."
HOMEPAGE = "http://www.eclipse.org/paho/"
SECTION = "console/network"
LICENSE = "EPL-1.0 | EDL-1.0"

LIC_FILES_CHKSUM = " \
        file://LICENSE;md5=fd3b896dadaeec3410d753ffaeadcfac \
"

PR = "r0"

SRC_URI = "git://github.com/eclipse/paho.mqtt.c.git"
SRCREV = "3b7ae6348bc917d42c04efa962e4868c09bbde9f"

S = "${WORKDIR}/git"

do_compile() {
    oe_runmake
}

do_install() {
    install -d ${D}${libdir}
    oe_libinstall -C build/output -so libpaho-mqtt3a ${D}${libdir}
    oe_libinstall -C build/output -so libpaho-mqtt3as ${D}${libdir}
    oe_libinstall -C build/output -so libpaho-mqtt3c  ${D}${libdir}
    oe_libinstall -C build/output -so libpaho-mqtt3cs ${D}${libdir}
    install -d ${D}${includedir}
    install -m 644 src/MQTTAsync.h ${D}${includedir}
    install -m 644 src/MQTTClient.h ${D}${includedir}
    install -m 644 src/MQTTClientPersistence.h ${D}${includedir}
}

DEPENDS = "openssl"
RDEPENDS_${PN} = "openssl"


