#
# Yocto Project Development Manual.
#

DESCRIPTION = "Camera application for Yocto build."
SECTION = "camera"

DEPENDS = "vlc go"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://src/${GO_IMPORT}/LICENSE;md5=1086bcb06321954f187efe031bdd856c"

SRC_URI = "git://github.com/daaaanil81/CameraWebRTC.git;protocol=https"
SRCREV = "a6c802c9c29abda7aa03bad1dbd5da3eb362493f"
UPSTREAM_CHECK_COMMITS = "1"

GO_IMPORT = "github.com/daaaanil81/CameraWebRTC"
GO_INSTALL = "${GO_IMPORT}/camera_daemon"
GO_WORKDIR = "${GO_INSTALL}"
export GO111MODULE="off"

inherit go

