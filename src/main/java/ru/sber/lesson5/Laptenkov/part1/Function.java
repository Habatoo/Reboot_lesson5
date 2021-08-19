package ru.sber.lesson5.Laptenkov.part1;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Класс {@link Function} с параметрами , часть из которых может отсутствовать,
 * а часть обязательная.
 *
 * @author habatoo
 */
public class Function {

    private UUID id;
    private String projectId;
    private String name;
    private String template;
    private String description;
    private List<String> endpoints;
    private Map<String, String> tags;
    private Map<String, String> environmentVariables;
    private String state;
    private LocalDateTime created;
    private LocalDateTime updated;

    /**
     * Конструктор класса {@link Function}.
     * в качестве входного параметра принимает объект {@link Builder}
     * с необходимым количеством инициализированных полей.
     *
     * @param builder
     */
    private Function(Builder builder) {
        if (null == builder) {
            throw new IllegalArgumentException("Provide correct builder");
        }
        this.id = builder.id;
        this.projectId = builder.projectId;
        this.name = builder.name;
        this.template = builder.template;
        this.description = builder.description;
        this.endpoints = builder.endpoints;
        this.tags = builder.tags;
        this.environmentVariables = builder.environmentVariables;
        this.state = builder.state;
        this.created = builder.created;
        this.updated = builder.updated;
    }

    /**
     * Метод {@link Builder#builder} использует паттерн Builder
     * возвращает
     *
     * @return объекта типа {@link Builder}.
     */
    public static Builder builder() {
        Builder builder = new Builder();
        return builder;
    }

    /**
     * Класс {@link Builder} использует паттерн Builder
     * для создания объекта типа {@link Function}.
     */
    public static class Builder {
        private UUID id;
        private String projectId;
        private String name;
        private String template;
        private String description;
        private List<String> endpoints;
        private Map<String, String> tags;
        private Map<String, String> environmentVariables;
        private String state;
        private LocalDateTime created;
        private LocalDateTime updated;

        Builder() {
        }

        public Builder setId(UUID id) {
            this.id = id;
            return this;
        }

        public Builder setProjectId(String projectId) {
            this.projectId = projectId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setTemplate(String template) {
            this.template = template;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setEndpoints(List<String> endpoints) {
            this.endpoints = endpoints;
            return this;
        }

        public Builder setTags(Map<String, String> tags) {
            this.tags = tags;
            return this;
        }

        public Builder setEnvironmentVariables(Map<String, String> environmentVariables) {
            this.environmentVariables = environmentVariables;
            return this;
        }

        public Builder setState(String state) {
            this.state = state;
            return this;
        }

        /**
         * Время создания устанавливается произвольно.
         *
         * @param created
         * @return поле объекта {@link Builder#created}
         */
        public Builder setCreated(LocalDateTime created) {
            this.created = created;
            return this;
        }

        /**
         * Время создания устанавливается текущее.
         *
         * @return поле объекта {@link Builder#created}
         */
        public Builder setCreated() {
            this.created = LocalDateTime.now();
            return this;
        }

        public Builder setUpdated(LocalDateTime updated) {
            this.updated = updated;
            return this;
        }

        /**
         * Метод {@link Builder#build} для создания объекта типа {@link Function}.
         *
         * @return объект типа {@link Function}.
         */
        public Function build() {
            Function function = null;
            if (validateFunction()) {
                function = new Function(this);
            } else {
                throw new IllegalArgumentException("Can't create valid Function object!");
            }
            return function;
        }

        /**
         * Метод {@link Builder#validateFunction} производит валидацию
         * в части проверки инициализации обязательных полей объекта {@link Function}.
         * Проверяются, что поля не пустые - не равны null:
         * <br>{@link Function#projectId}
         * <br>{@link Function#name}
         * <br>{@link Function#created}
         *
         * @return true в случае успешной проверки обязательных параметров.
         */
        private boolean validateFunction() {
            return (projectId != null && name != null & created != null);
        }

        /**
         * Отображение всех полей объекта {@link Function}.
         *
         * @return строку String с полями объекта {@link Function}.
         */
        @Override
        public String toString() {
            return "Function{" +
                    "id=" + id +
                    ", projectId='" + projectId + '\'' +
                    ", name='" + name + '\'' +
                    ", template='" + template + '\'' +
                    ", description='" + description + '\'' +
                    ", endpoints=" + endpoints +
                    ", tags=" + tags +
                    ", environmentVariables=" + environmentVariables +
                    ", state='" + state + '\'' +
                    ", created=" + created +
                    ", updated=" + updated +
                    '}';
        }

    }
}