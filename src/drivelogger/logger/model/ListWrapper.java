package drivelogger.logger.model;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "entries")
public class ListWrapper {
	private List<LogEntry> entries;
	@XmlElement(name = "entry")
	public List<LogEntry> getEntries() {
		return entries;
	}
	public void setEntries(List<LogEntry> entries) {
		this.entries = entries;
	}

}
