#
# Yocto Project Development Manual.
#

DESCRIPTION = "Camera application for Yocto build."
SECTION = "camera"

DEPENDS = "vlc go"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://src/${GO_IMPORT}/LICENSE;md5=1086bcb06321954f187efe031bdd856c"

SRC_URI = "git://github.com/daaaanil81/CameraWebRTC.git;protocol=https"
SRCREV = "0d95683fbe2d809d276ad04ee9934974f43fc488"
UPSTREAM_CHECK_COMMITS = "1"

GO_IMPORT = "github.com/daaaanil81/CameraWebRTC"
GO_INSTALL = "${GO_IMPORT}/camera_daemon"
GO_WORKDIR = "${GO_INSTALL}"
export GO111MODULE="off"

inherit go

do_install_append () {
    install -d ${D}${sysconfdir}/camera_server
    cp -r ${WORKDIR}/${BP}/src/${GO_IMPORT}/camera_daemon/static ${D}${sysconfdir}/camera_server/
}

