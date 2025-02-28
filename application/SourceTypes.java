package application;

public class SourceTypes {
	private String sourceId;
    private String sourceTypeCode;
    private String sourceTypeDesc;

    public enum SourceType {
        BA("Bank Account"),
        WA("Wallet"),
        TPT("Third Party Txn");

        private final String description;

        SourceType(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public String getSourceTypeCode() {
        return sourceTypeCode;
    }

    public void setSourceTypeCode(String sourceTypeCode) {
        this.sourceTypeCode = sourceTypeCode;
    }

    public String getSourceTypeDesc() {
        return sourceTypeDesc;
    }

    public void setSourceTypeDesc(String sourceTypeDesc) {
        this.sourceTypeDesc = sourceTypeDesc;
    }

    public static void main(String[] args) {
   
    }
}

