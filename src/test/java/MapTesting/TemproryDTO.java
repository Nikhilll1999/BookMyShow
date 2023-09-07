package MapTesting;

import lombok.Data;

@Data
public class TemproryDTO implements Comparable<TemproryDTO> {
    private String one;


    public TemproryDTO(String one){
        this.one = one;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        TemproryDTO other = (TemproryDTO) obj;

        if (one == null) {
            if (other.one != null)
                return false;
        } else if (!one.equals(other.one))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((one == null) ? 0 : one.hashCode());
        return result;
    }

    @Override
    public int compareTo(TemproryDTO other) {
        if (this.one == null && other.one == null) {
            return 0;
        } else if (this.one == null) {
            return -1;
        } else if (other.one == null) {
            return 1;
        } else {
            return this.one.compareTo(other.one);
        }
    }

}
