package LoadTestClient;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
class ThreadDetails {
    private String name;
    private String state;
    private String alive;
    private String stacktrace;

    public static ThreadDetails.ThreadDetailsBuilder builder() {
        return new ThreadDetails.ThreadDetailsBuilder();
    }

    public String getName() {
        return this.name;
    }

    public String getState() {
        return this.state;
    }

    public String getAlive() {
        return this.alive;
    }

    public String getStacktrace() {
        return this.stacktrace;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setAlive(String alive) {
        this.alive = alive;
    }

    public void setStacktrace(String stacktrace) {
        this.stacktrace = stacktrace;
    }

    public ThreadDetails() {
    }

    public ThreadDetails(String name, String state, String alive, String stacktrace) {
        this.name = name;
        this.state = state;
        this.alive = alive;
        this.stacktrace = stacktrace;
    }

    public static class ThreadDetailsBuilder {
        private String name;
        private String state;
        private String alive;
        private String stacktrace;

        ThreadDetailsBuilder() {
        }

        public ThreadDetails.ThreadDetailsBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ThreadDetails.ThreadDetailsBuilder state(String state) {
            this.state = state;
            return this;
        }

        public ThreadDetails.ThreadDetailsBuilder alive(String alive) {
            this.alive = alive;
            return this;
        }

        public ThreadDetails.ThreadDetailsBuilder stacktrace(String stacktrace) {
            this.stacktrace = stacktrace;
            return this;
        }

        public ThreadDetails build() {
            return new ThreadDetails(this.name, this.state, this.alive, this.stacktrace);
        }

        public String toString() {
            return "ThreadDetails.ThreadDetailsBuilder(name=" + this.name + ", state=" + this.state + ", alive=" + this.alive + ", stacktrace=" + this.stacktrace + ")";
        }
    }
}
