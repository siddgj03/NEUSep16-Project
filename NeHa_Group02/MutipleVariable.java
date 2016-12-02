package finalProject;

class MutableVariable {
	
	    String strVal;
	    Integer intVal;
	    Double dblVal;

	    public MutableVariable(Double dblVal) {
	        this.dblVal = dblVal;
	    }

	    public MutableVariable(Integer intVal) {
	        this.intVal = intVal;
	    }

	    public MutableVariable(String strVal) {
	        this.strVal = strVal;
	    }

	    /**
	     * Gets value of String/Int/Double from the class
	     * @param <T>
	     * @return <T>
	     */
	    @SuppressWarnings("unchecked")
	    public <T> T getValue() {
	        if (intVal != null) {
	            return (T) Integer.valueOf(intVal);
	        } else if (dblVal != null) {
	            return (T) Double.valueOf(dblVal);
	        } else {
	            return (T) String.valueOf(strVal);
	        }
	    }

	    /**
	     * Compares values of any type
	     * @param var
	     * @return int
	     */
	    public int compareTo(MutableVariable var) {
	        if (intVal != null) {
	            return intVal.compareTo(var.getValue());
	        } else if (dblVal != null) {
	            return dblVal.compareTo(var.getValue());
	        } else {
	            return strVal.compareTo(var.getValue());
	        }
	    }
	}

