function toggleBtn(idContent) {
    const contentVideo = document.getElementById(idContent);
    if (contentVideo.style.display === 'none') {
        contentVideo.style.display = 'block';
    } else {
        contentVideo.style.display = 'none';
    }
}