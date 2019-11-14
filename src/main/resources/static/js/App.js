/**
 * Global function for loading local files via servlet
 */
function setCurrentXml(data, filename)
{
    if (window.parent != null && window.parent.openFile != null)
    {
        window.parent.openFile.setData(data, filename);
    }
};