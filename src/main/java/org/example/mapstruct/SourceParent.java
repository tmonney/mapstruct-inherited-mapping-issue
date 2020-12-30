package org.example.mapstruct;

public class SourceParent {
    private Holder holder;

    public Holder getHolder() {
        return holder;
    }

    // Additional getter that points to the same field to verify that the naming is relevant
    public Holder getHolderBis() {
        return holder;
    }

    public void setHolder(Holder holder) {
        this.holder = holder;
    }

    public static class Holder {
        private String parentValue1;
        private Integer parentValue2;

        public Holder(String parentValue1, Integer parentValue2) {
            this.parentValue1 = parentValue1;
            this.parentValue2 = parentValue2;
        }

        public String getParentValue1() {
            return parentValue1;
        }

        public void setParentValue1(String parentValue1) {
            this.parentValue1 = parentValue1;
        }

        public Integer getParentValue2() {
            return parentValue2;
        }

        public void setParentValue2(Integer parentValue2) {
            this.parentValue2 = parentValue2;
        }
    }
}
