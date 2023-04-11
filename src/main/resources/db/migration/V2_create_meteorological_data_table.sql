CREATE TABLE IF NOT EXISTS meteorological_data (
  id BIGSERIAL NOT NULL,
  city VARCHAR(45) NOT NULL,
  weather_date DATE NOT NULL,
  morning_weather VARCHAR(20) NOT NULL,
  night_weather VARCHAR(20) NOT NULL,
  max_temperature INT NOT NULL,
  min_temperature INT NOT NULL,
  humidity INT NOT NULL,
  precipitation INT NOT NULL,
  windSpeed INT NOT NULL,
  PRIMARY KEY (id)
);